//package com.nuhin13.data.features.user
//
//import com.nuhin13.data.features.user.datasource.UserDataSource
//import com.nuhin13.domain.feature.post.entity.Owner
//import com.nuhin13.domain.feature.user.entity.OwnerList
//import com.nuhin13.domain.feature.user.repository.UserRepository
//import javax.inject.Inject
//
//class UserRepoImpl @Inject constructor(
//    private val userDataSource: UserDataSource
//) : UserRepository {
//    override suspend fun getUserList(): OwnerList {
//
//        val ownerList = OwnerList(arrayListOf())
//        val response = userDataSource.getUserList()
//
//        if (response.data.size > 0) {
//            val owners = ArrayList<Owner>()
//            for (owner in response.data) {
//                owners.add(
//                    Owner(
//                        profilePic = owner.picture,
//                        fullName = owner.title + ". " + owner.firstName + " " + owner.lastName
//                    )
//                )
//            }
//            ownerList.ownerList = owners
//        }
//
//        return ownerList
//    }
//
//    override suspend fun getUserDetails(): Owner {
//        TODO("Not yet implemented")
//    }
//}