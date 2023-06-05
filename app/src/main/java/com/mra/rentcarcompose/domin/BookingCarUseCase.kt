package com.mra.rentcarcompose.domin

import com.mra.rentcar.data.model.BookingCarInputModel
import com.mra.rentcar.utils.ResponseState
import com.mra.rentcarcompose.data.Repository
import javax.inject.Inject

interface BookingCarUseCase {
    suspend operator fun invoke(bookingCarInputModel: BookingCarInputModel): ResponseState<Boolean>
}

class BookingCarUseCaseImpl @Inject constructor(
    private val repository: Repository
): BookingCarUseCase {
    override suspend fun invoke(bookingCarInputModel: BookingCarInputModel): ResponseState<Boolean> {
        return repository.bookingCar(bookingCarInputModel)
    }

}