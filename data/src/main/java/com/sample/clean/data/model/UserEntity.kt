package com.sample.clean.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.sample.clean.data.Constants
import com.sample.clean.data.model.base.EntityMapper
import com.sample.clean.data.model.base.ModelEntity
import com.sample.clean.data.utils.toTimeLong
import com.sample.clean.data.utils.toTimeString
import com.sample.clean.domain.model.User

@Entity(tableName = "user", primaryKeys = ["id"])
data class UserEntity(
    @field: SerializedName("id") val id: String,
    @field: SerializedName("name") val name: String? = null,
    @field: SerializedName("username") val username: String? = null,
    @field: SerializedName("email") val email: String? = null,
    @field: SerializedName("phone") val phone: String? = null,
    @field: SerializedName("address") val address: String? = null,
    @field: SerializedName("created_date") val createdDate: String? = null
) : ModelEntity()


class UserEntityMapper : EntityMapper<User, UserEntity> {

    override fun mapToDomain(entity: UserEntity) = User(
        id = entity.id,
        name = entity.name,
        username = entity.username,
        email = entity.email,
        phone = entity.phone,
        address = entity.address,
        createdDate = entity.createdDate?.toTimeLong(Constants.FORMAT_YYYY_MM_DD)
    )

    override fun mapToEntity(model: User) = UserEntity(
        id = model.id,
        name = model.name,
        username = model.username,
        email = model.email,
        phone = model.phone,
        address = model.address,
        createdDate = model.createdDate?.toTimeString(Constants.FORMAT_YYYY_MM_DD)
    )
}
