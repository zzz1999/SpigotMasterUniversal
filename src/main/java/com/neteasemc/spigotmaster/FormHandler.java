package com.neteasemc.spigotmaster;

import com.google.common.base.Charsets;
import com.neteasemc.protocol.custom.packet.formPacket.FormPacket;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMap;
import it.unimi.dsi.fastutil.shorts.Short2ObjectMaps;
import it.unimi.dsi.fastutil.shorts.Short2ObjectOpenHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.entity.Player;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.impl.FormDefinition;
import org.geysermc.cumulus.form.impl.FormDefinitions;

public class FormHandler {
   private final FormDefinitions formDefinitions = FormDefinitions.instance();
   private final Short2ObjectMap<Form> storedForms = Short2ObjectMaps.synchronize(new Short2ObjectOpenHashMap<>());
   private final AtomicInteger nextFormId = new AtomicInteger(0);
   private GeyserMessageListener listener;

   public FormHandler(GeyserMessageListener listener) {
      this.listener = listener;
   }

   public boolean handleFormResponse(FormPacket packet, Player player) {
      this.callResponseConsumer(packet.getFormData());
      return true;
   }

   public boolean sendForm(Player player, Form form) {
      byte[] formData = this.createFormData(form);
      FormPacket packet = new FormPacket(formData);
      this.listener.sendToClient(player, packet);
      return true;
   }

   public byte[] createFormData(Form form) {
      short formId = this.getNextFormId();
      this.storedForms.put(formId, form);
      FormDefinition<Form, ?, ?> definition = this.formDefinitions.definitionFor(form);
      byte[] jsonData = definition.codec().jsonData(form).getBytes(Charsets.UTF_8);
      byte[] data = new byte[jsonData.length + 3];
      data[0] = (byte)definition.formType().ordinal();
      data[1] = (byte)(formId >> 8 & 0xFF);
      data[2] = (byte)(formId & 0xFF);
      System.arraycopy(jsonData, 0, data, 3, jsonData.length);
      return data;
   }

   protected boolean callResponseConsumer(byte[] data) {
      Form storedForm = this.storedForms.remove(this.getFormId(data));
      if (storedForm != null) {
         String responseData = new String(data, 2, data.length - 2, Charsets.UTF_8);

         try {
            FormDefinition<Form, ?, ?> definition = this.formDefinitions.definitionFor(storedForm);
            definition.handleFormResponse(storedForm, responseData);
         } catch (Exception e) {
            this.listener.getPlugin().getLogger().info("处理formui response失败:" + e);
         }

         return true;
      } else {
         return false;
      }
   }

   protected short getFormId(byte[] data) {
      return (short)((data[0] & 255) << 8 | data[1] & 0xFF);
   }

   protected short getNextFormId() {
      return (short)this.nextFormId.getAndUpdate(number -> number == 32767 ? 0 : number + 1);
   }

   public GeyserMessageListener getListener() {
      return this.listener;
   }
}
