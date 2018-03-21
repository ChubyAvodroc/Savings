package com.chuby.savings.ui.accounts

/**
 * Created by developer on 14/03/18.
 */
data class AccountModel(
    val total: Double,
    val accounts: List<Account>
)

data class Account(
    val name: String,
    val amount: Double
)