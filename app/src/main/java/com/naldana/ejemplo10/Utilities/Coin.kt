package com.naldana.ejemplo10.Utilities

import android.os.Parcel
import android.os.Parcelable
@Parcelize
data class Coin (
    var _id: String,
    val name:String,
    val country:String,
    val value: Float,
    val value_us: Float,
    val year: Int,
    val review:String,
    val isAvailable:Boolean,
    val img:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    ) {
    }
    
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(name)
        parcel.writeString(country)
        parcel.writeFloat(value)
        parcel.writeFloat(value_us)
        parcel.writeInt(year)
        parcel.writeString(review)
        parcel.writeByte(if (isAvailable) 1 else 0)
        parcel.writeString(img)
    }
    
    override fun describeContents(): Int {
        return 0
    }
    
    companion object CREATOR : Parcelable.Creator<Coin> {
        override fun createFromParcel(parcel: Parcel): Coin {
            return Coin(parcel)
        }
        
        override fun newArray(size: Int): Array<Coin?> {
            return arrayOfNulls(size)
        }
    }
}

annotation class Parcelize
