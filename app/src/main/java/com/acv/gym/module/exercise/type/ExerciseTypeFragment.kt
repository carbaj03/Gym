package com.acv.gym.module.exercise.type

import com.acv.gym.R
import com.acv.gym.commons.extension.done
import com.acv.gym.commons.extension.getArgId
import com.acv.gym.commons.extension.gridLayoutManager
import com.acv.gym.commons.extension.inject
import com.acv.gym.domain.model.ExerciseType
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.session.ExerciseTypeNav
import com.acv.gym.presentation.module.exercise.type.ExerciseTypePresenter
import com.acv.gym.presentation.module.exercise.type.ExerciseTypeView
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.ExerciseTypeAdapter
import kotlinx.android.synthetic.main.fragment_list.*


class ExerciseTypeFragment : BaseFragment<ExerciseTypeView, ExerciseTypePresenter>(), ExerciseTypeView {
    override fun setupComponent() = inject()

    override fun onCreate() = presenter.loadExerciseType(getArgId())

    override fun getLayout() = R.layout.fragment_list

    override fun show(exerciseTypes: List<ExerciseType>) = setRecycler(exerciseTypes)

    private fun setRecycler(exerciseTypes: List<ExerciseType>) = with(rvItems) {
        layoutManager = gridLayoutManager()
        adapter = ExerciseTypeAdapter(
                items = exerciseTypes,
                listener = { presenter.checkExercise(it) },
                holder = ::ExerciseTypeViewHolder,
                layout = R.layout.item_exercise_type)
    }

    override fun showNetworkError() = TODO("not implemented")

    override fun showServerError() = TODO("not implemented")

    override fun goToExercise(id: Id) = done(ExerciseTypeNav(id))
}