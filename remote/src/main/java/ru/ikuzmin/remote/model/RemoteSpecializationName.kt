package ru.ikuzmin.remote.model

import com.google.gson.annotations.SerializedName
import ru.ikuzmin.domain.model.SpecializationName

data class RemoteSpecializationName(
    @SerializedName("Name")
    override val name: String
) : SpecializationName