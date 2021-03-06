package com.mizukami2005.mizukamitakamasa.qiitaclient.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mizukamitakamasa on 2016/09/24.
 */

data class User(var id: String = "",
                var name: String = "",
                var profileImageUrl: String = "") : Parcelable {

  companion object {
    @JvmField
    val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
      override fun createFromParcel(source: Parcel): User = source.run {
        User(readString(), readString(), readString())
      }

      override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
  }

  override fun describeContents(): Int = 0

  override fun writeToParcel(dest: Parcel, flags: Int) {
    dest.run {
      writeString(id)
      writeString(name)
      writeString(profileImageUrl)
    }
  }
}

