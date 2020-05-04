package groshevdg.foodex.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import groshevdg.foodex.model.Restaurant
import java.lang.reflect.Type
import java.util.*

class DataTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun stringToList(data: String?): List<Restaurant?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Restaurant?>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun ListToString(someObjects: List<Restaurant?>?): String {
        return gson.toJson(someObjects)
    }
}