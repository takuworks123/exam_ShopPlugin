package net.efcrafterz.exam_ShopPlugin

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class Item(
    private val material: Material,
    private val name: String = "",
    private val lore: List<String> = listOf()
){

    private val item = ItemStack(material)

    init {
        val meta: ItemMeta = item.itemMeta!!
        meta.setDisplayName(name)
        meta.lore = lore
        item.itemMeta = meta
    }

    fun getName() : String {
        return name
    }

    fun getLore() : List<String> {
        return lore
    }

    fun setName(newName: String) {
        val meta: ItemMeta = item.itemMeta!!
        meta.setDisplayName(newName)
        item.itemMeta = meta
    }

    fun setLore(newLore: List<String>) {
        val meta: ItemMeta = item.itemMeta!!
        meta.lore = newLore
        item.itemMeta = meta
    }

    fun get(): ItemStack {
        return item
    }
}