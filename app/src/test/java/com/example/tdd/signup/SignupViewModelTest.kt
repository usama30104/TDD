package com.example.tdd.signup

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SignupViewModelTest {
    private lateinit var viewModel: SignupViewModel

    @Before
    fun setup() {
        viewModel = SignupViewModel()
    }

    @Test
    fun `test initial state`() = runTest {
        val expectedState = SignupViewModel.SignUpState()//defualt state
        assertEquals(expectedState, viewModel.uiState)
    }

    @Test
    fun `test user name`() = runTest {
        val expectedState = SignupViewModel.SignUpState(
            name = "usama"
        )
        viewModel.updateUserName("usama")
        assertEquals(expectedState, viewModel.uiState)
    }

    @Test
    fun `valid email should return true`() = runBlocking {

        val viewModel = SignupViewModel()
        val userEmail = "usama30104@gmail.com"

        viewModel.isEmailValid(userEmail)

        val expectedState = SignupViewModel.SignUpState(
            email = userEmail,
            check = true
        )
        assertTrue(viewModel.uiState == expectedState)
    }

    @Test
    fun `invalid email should return false`() = runBlocking {

        val viewModel = SignupViewModel()
        val userEmail = "usama30104gmail.com"
        viewModel.isEmailValid(userEmail)
        val expectedState = SignupViewModel.SignUpState(
            email = userEmail,
            check = false
        )
        assertTrue(viewModel.uiState == expectedState)
    }

    @Test
    fun `valid password should return true`() = runBlocking {
        val viewModel = SignupViewModel()
        val userPassword = "Usama!1234"
        viewModel.isPasswordValid(userPassword)

        val expectedState = SignupViewModel.SignUpState(
            password = userPassword,
            check = true
        )
        assertTrue(viewModel.uiState == expectedState)
    }

    @Test
    fun `invalid password should return false`() = runBlocking {
        val viewModel = SignupViewModel()
        val userPassword = "123"
        viewModel.isPasswordValid(userPassword)

        val expectedState = SignupViewModel.SignUpState(
            password = userPassword,
            check = false
        )
        assertTrue(viewModel.uiState == expectedState)
    }
}

