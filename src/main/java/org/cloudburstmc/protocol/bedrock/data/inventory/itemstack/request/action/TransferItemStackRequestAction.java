package org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.action;

import org.cloudburstmc.protocol.bedrock.data.inventory.itemstack.request.ItemStackRequestSlotData;

public interface TransferItemStackRequestAction extends ItemStackRequestAction {
   int getCount();

   ItemStackRequestSlotData getSource();

   ItemStackRequestSlotData getDestination();
}
