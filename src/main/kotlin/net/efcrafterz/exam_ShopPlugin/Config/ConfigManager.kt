package net.efcrafterz.exam_ShopPlugin.Config

import net.efcrafterz.exam_ShopPlugin.Exam_ShopPlugin
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

abstract class ConfigManager(private val plugin: Exam_ShopPlugin, private val filename: String) {

    private var configFile: File = File(plugin.dataFolder, filename)
    private lateinit var conf: FileConfiguration

    init {
        saveDefault()
    }

    abstract fun load()

    fun getConfig(): FileConfiguration {
        return conf
    }

    fun saveDefault() {
        if (!configFile.exists()) {
            plugin.saveResource(filename, false) // デフォルト設定を保存
        }
        conf = YamlConfiguration.loadConfiguration(configFile)

//        val defConfigStream: InputStream? = plugin.getResource(filename)
//
//        if (defConfigStream != null) {
//            conf.setDefaults(YamlConfiguration.loadConfiguration(InputStreamReader(defConfigStream, StandardCharsets.UTF_8)))
//            defConfigStream.close()
//        }
    }

    fun save() {
        try {
            conf.save(configFile)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}