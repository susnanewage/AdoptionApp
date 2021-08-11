package com.example.adoptionapp.model

import android.os.Parcel
import android.os.Parcelable

data class PuppyModel(
    val id: Int? = 0,
    val name: String? = null,
    val sex: String? = null,
    val lifeSpan: String? = null,
    val orgin: String? = null,
    val color: String? = null,
    val description: String? = null,
    val price: String? = null,
    val img: Int? = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(sex)
        parcel.writeString(lifeSpan)
        parcel.writeString(orgin)
        parcel.writeString(color)
        parcel.writeString(description)
        parcel.writeString(price)
        parcel.writeValue(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PuppyModel> {
        override fun createFromParcel(parcel: Parcel): PuppyModel {
            return PuppyModel(parcel)
        }

        override fun newArray(size: Int): Array<PuppyModel?> {
            return arrayOfNulls(size)
        }
    }
}