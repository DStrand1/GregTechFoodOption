package com.bruberu.gregtechfoodoption.machines;

import gregicadditions.client.ClientHandler;
import gregicadditions.integrations.exnihilocreatio.machines.MetaTileEntitySieve;
import gregicadditions.machines.TileEntitySteamMixer;
import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class MetaTileEntityBioReactor extends SimpleMachineMetaTileEntity implements ITieredMetaTileEntity {
    public MetaTileEntityBioReactor(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, GARecipeMaps.BIO_REACTOR_RECIPES, ClientHandler.ORGANIC_REPLICATOR_OVERLAY, tier);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder metaTileEntityHolder) {
        return new MetaTileEntityBioReactor(this.metaTileEntityId, this.getTier());
    }

    @Override
    public IItemHandlerModifiable createImportItemHandler() {
        return new ItemStackHandler(3);
    }

    @Override
    public IItemHandlerModifiable createExportItemHandler() {
        return new ItemStackHandler(3);
    }

    @Override
    public FluidTankList createImportFluidHandler() {
        return new FluidTankList(false, new FluidTank(32000), new FluidTank(32000), new FluidTank(32000));
    }

    @Override
    protected FluidTankList createExportFluidHandler() {
        return new FluidTankList(false, new FluidTank(32000), new FluidTank(32000));
    }
}
