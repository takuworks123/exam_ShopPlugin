package net.efcrafterz.exam_ShopPlugin.inventoryitem

import org.bukkit.Material
import xyz.xenondevs.invui.gui.PagedGui
import xyz.xenondevs.invui.item.ItemProvider
import xyz.xenondevs.invui.item.builder.ItemBuilder
import xyz.xenondevs.invui.item.impl.controlitem.PageItem

class ForwardItem : PageItem(true) {

    override fun getItemProvider(gui: PagedGui<*>): ItemProvider {
        val builder = ItemBuilder(Material.ARROW)
        builder.setDisplayName("Next page")
            .addLoreLines(
                if (gui.hasNextPage())
                    "Go to page " + (gui.currentPage + 2) + "/" + gui.pageAmount
                else "There are no more pages"
            )
        return builder
    }

}