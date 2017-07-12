package com.acv.gym.data.db.cache.datasource

import com.acv.gym.data.db.GymDataSource
import com.acv.gym.data.db.cache.model.*
import com.acv.gym.domain.GenericError
import com.acv.gym.domain.GymResult
import com.acv.gym.domain.model.*
import com.acv.gym.domain.model.session.Set
import com.acv.gym.domain.model.session.SessionExercise
import com.acv.gym.domain.service.Id
import kategory.Either
import java.util.*

/**
 * Created by alejandro on 21/05/2017.
 */
class GymCache : GymDataSource {
    override fun getExercisesBy(idMuscleGroup: Id, idExerciseType: Id): GymResult<List<Exercise>> {
        TODO("not implemented")
    }

    override fun getExerciseTypesBy(idMuscleGroup: Id): GymResult<List<ExerciseType>> {
        TODO("not implemented")
    }

    override fun getAllSession() =
            Either.Right(
                    listOf(
                            SessionCache("1", "Sessoin 1", Date())
                    ).map { it.map() }
            )

    override fun getExercise(id: Id) =
            Either.Right(
                    listOf(
                            ExerciseCache("1", "Curl", "1", "1")
                    ).map { it.map() }
            )

    override fun getAllExercises() =
            Either.Right(
                    listOf(
                            ExerciseCache("1", "Curl", "1", "1")
                            , ExerciseCache("2", "Press Banca Plano", "1", "1")
                            , ExerciseCache("3", "Dominadas", "1", "1")
                            , ExerciseCache("4", "Dips", "1", "1")
                            , ExerciseCache("5", "Squat", "1", "1")
                    ).map { it.map() }
            )

    override fun getAllExerciseTypes() =
            Either.Right(
                    listOf(
                            ExerciseTypeCache("1", "Dumbell")
                            , ExerciseTypeCache("2", "Bar")
                            , ExerciseTypeCache("3", "Cable")
                            , ExerciseTypeCache("4", "Body Weight")
                            , ExerciseTypeCache("4", "Machine")
                    ).map { it.map() }
            )

    override fun getAllMuscleGroups() =
            Either.Right(
                    listOf(
                            MuscleGroupCache("1", "Pecho")
                    ).map { it.map() }
            )


    override fun getAllRoutines() =
            Either.Right(
                    listOf(
                            RoutineCache("1", "Full Body", "")
                    ).map { it.map() }
            )

    val sessionExercises = Either.Right(
            listOf(
                    SessionExerciseCache(
                            "1",
                            ExerciseCache("1", "Curl", "1", "1"),
                            listOf(
                                    SessionSetCache("1", 20f, 10, ""),
                                    SessionSetCache("2", 20f, 10, "")
                            ),
                            "1"
                    ),
                    SessionExerciseCache(
                            "2",
                            ExerciseCache("1", "Curl", "1", "1"),
                            listOf(
                                    SessionSetCache("1", 20f, 10, ""),
                                    SessionSetCache("2", 20f, 10, "")
                            ),
                            "1"
                    )
                    ,
                    SessionExerciseCache(
                            "3",
                            ExerciseCache("1", "Curl", "1", "1"),
                            listOf(
                                    SessionSetCache("1", 20f, 10, ""),
                                    SessionSetCache("2", 20f, 10, "")
                            ),
                            "1")
            ).map { it.map() }
    )

    override fun getBySession(id: Id) = sessionExercises

    override fun getAllSessionExercises() = sessionExercises

    override fun getSessionSetBySessionExercise(id: Id): GymResult<List<Set>> {
        TODO("not implemented")
    }

    override fun persistSessionExercises(sessionExercises: List<SessionExercise>): Either<GenericError, List<SessionExercise>> {
        TODO("not implemented")
    }

    override fun getLaunchApp(): Either<GenericError, List<LaunchApp>> {
        TODO("not implemented")
    }
}
