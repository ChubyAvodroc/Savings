package com.chuby.savings.ui.accounts

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.chuby.savings.R
import kotlinx.android.synthetic.main.activity_accounts.*

class AccountsActivity : AppCompatActivity() {

    private val TAG = "AccountsActivity"

    private val accountViewModel: AccountViewModel by lazy {
        ViewModelProviders.of(this).get(AccountViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)

        setupRecycler()
    }

    override fun onResume() {
        super.onResume()
        accountViewModel.getAccounts().observe(this, Observer(::updateUI))
    }

    private fun setupRecycler() {
        accounts.layoutManager = LinearLayoutManager(this)
    }

    private fun updateUI(accountModel: AccountModel?) {
        Log.i(TAG, "The accounts are: $accountModel")
    }
}
