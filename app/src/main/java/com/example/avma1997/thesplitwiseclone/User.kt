package com.example.avma1997.thesplitwiseclone

import java.io.Serializable

/**
 * Created by Avma1997 on 11/1/2017.
 */


data class User(var id:Int?,var name:String?,var emailId:String?,var imageUrl:String?,var balances:ArrayList<Balance>?,var totalBalance:String?,var activities:ArrayList<Activitie>?,  var phoneNo:String?,var groups: ArrayList<Group>?,var friends:ArrayList<User>?,var bills:ArrayList<Bill>?):Serializable
data class Balance(var imageUrl:String?,var name:String?,var amount:String?)
data class Activitie(var title:String?,var transaction:String?,var date:String?)
data class Group(var title:String?,var type:String?,var members:ArrayList<User>?)
data class Bill(var description:String?,var type:String?,var amount:String?,var date:String?,var group:Group?,var billPhoto:String?,var notes:String?,var payers:ArrayList<User>?,var members:ArrayList<User>?,var splittingtype:String?)
data class Catogery(var name:String?,var url:String?)