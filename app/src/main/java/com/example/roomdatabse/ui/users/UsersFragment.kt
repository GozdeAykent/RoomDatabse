package com.example.roomdatabse.ui.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.roomdatabse.R
import com.example.roomdatabse.RoomDatabase
import com.example.roomdatabse.data.adapter.UsersAdapter
import com.example.roomdatabse.data.state.UserListState
import com.example.roomdatabse.databinding.FragmentUsersBinding
import kotlinx.coroutines.launch


class UsersFragment : Fragment(R.layout.fragment_users) {

    private lateinit var binding: FragmentUsersBinding
    private val viewModel:UsersViewModel by activityViewModels()
    private var adapter:UsersAdapter?=null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentUsersBinding.bind(view)

        viewModel.getAllUsers(RoomDatabase.getDatabase(requireContext()))

        observeListState()
    }

    private fun observeListState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModel.userListState.collect(){
                    when(it){
                        is UserListState.Idle->{}
                        is UserListState.Loading->{}
                        is UserListState.Empty->{}
                        is UserListState.Result->{
                            adapter=UsersAdapter(requireContext(),it.users)
                            binding.rvUsers.adapter=adapter
                        }

                        is UserListState.Error->{}
                    }
                }
            }
        }
    }


//
//    private fun observeUserListState() {
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.CREATED){
//                viewModel.userListState.collect{
//                    when(it){
//                        is UserListState.Idle->{}
//                        is UserListState.Loading->{
//
//                        }
//                        is UserListState.Result->{
//                            binding.btnUserAddScreen.isVisible = false
//
//                            adapter = UsersAdapter(this@UsersActivity, it.users ,this@UsersActivity::onClick){user->
//                                //remove islemi
//                                viewModel.removeUser(RoomDatabase.getDatabase(this@UsersActivity), user)
//                            }
//                            binding.rvUsers.adapter = adapter
//
//                        }
//                        is UserListState.Empty->{
//                            showSnackBar(binding.rvUsers,"Hic kullanici yok!")
//                            binding.btnUserAddScreen.isVisible = true
//
//                        }
//                        is UserListState.Error->{
//
//                        }
//                    }
//                }
//            }
//        }
//    }


}