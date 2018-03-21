package com.chuby.savings.ui.accounts

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by developer on 14/03/18.
 */
class AccountViewModel : ViewModel() {

    private val accounts: MutableLiveData<AccountModel> = MutableLiveData()

    fun getAccounts(): LiveData<AccountModel> {

        loadAccounts()

        return accounts
    }

    private fun loadAccounts() {
        val accounts: MutableList<Account> = ArrayList()

        accounts.add(Account("Cuenta 1", 3000.87))
        accounts.add(Account("Cuenta 2", 250.54))
        accounts.add(Account("Cuenta 3", 13400.15))
        accounts.add(Account("Cuenta 4", 67.50))
        accounts.add(Account("Cuenta 5", 907.34))

        this.accounts.value = AccountModel(accounts.sumByDouble { it.amount }, accounts)
    }
}