package com.mra.rentcarcompose.di

import com.mra.rentcarcompose.domin.BookingCarUseCase
import com.mra.rentcarcompose.domin.BookingCarUseCaseImpl
import com.mra.rentcarcompose.domin.GetCarsUseCase
import com.mra.rentcarcompose.domin.GetCarsUseCaseImpl
import com.mra.rentcarcompose.domin.UserLoginUseCase
import com.mra.rentcarcompose.domin.UserLoginUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesProvide {

    @Binds
    abstract fun provideUserLoginUseCase(impl: UserLoginUseCaseImpl): UserLoginUseCase

    @Binds
    abstract fun provideGetCarsListUseCase(impl: GetCarsUseCaseImpl): GetCarsUseCase

    @Binds
    abstract fun provideBookingCarUseCase(impl: BookingCarUseCaseImpl): BookingCarUseCase


}