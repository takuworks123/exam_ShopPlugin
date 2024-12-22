package net.efcrafterz.exam_ShopPlugin

import net.efcrafterz.exam_ShopPlugin.inventoryitem.PurchasableItem

class Shop(
    val name: String = "<none>",
    val items: List<PurchasableItem> = listOf()
) {
}