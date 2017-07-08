package com.acv.gym.commons.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import android.widget.SeekBar
import com.acv.gym.GymApplication
import com.acv.gym.R
import com.acv.gym.commons.listener.SeekBarListener
import com.acv.gym.di.module.*
import com.acv.gym.domain.usecase.Command
import com.acv.gym.domain.usecase.Id
import com.acv.gym.module.exercise.ExerciseActivity
import com.acv.gym.module.exercise.ExerciseFragment
import com.acv.gym.module.exercise.type.ExerciseTypeActivity
import com.acv.gym.module.exercise.type.ExerciseTypeFragment
import com.acv.gym.module.muscle.group.MuscleGroupActivity
import com.acv.gym.module.muscle.group.MuscleGroupFragment
import com.acv.gym.module.rep.RepActivity
import com.acv.gym.module.rep.RepFragment
import com.acv.gym.module.routine.RoutineActivity
import com.acv.gym.module.session.Nav
import com.acv.gym.module.session.NewSessionActivity
import com.acv.gym.module.session.SessionActivity
import com.acv.gym.module.session.SessionFragment
import com.acv.gym.module.session.set.SessionSetActivity
import com.acv.gym.module.session.set.SessionSetFragment
import com.acv.gym.module.splash.SplashActivity
import com.acv.gym.module.weight.WeightActivity
import com.acv.gym.module.weight.WeightFragment
import com.acv.gym.presentation.GymView
import com.acv.gym.presentation.Presenter
import com.acv.gym.ui.BaseActivity
import com.acv.gym.ui.BaseFragment
import com.acv.gym.ui.commons.setSlideExitToRightAnimation
import com.acv.gym.ui.commons.setSlideRightAnimation
import kategory.Option
import kotlinx.android.synthetic.main.toobar.*
import org.jetbrains.anko.backgroundResource


const val HOME = android.R.id.home
const val DONE = R.id.done
const val DELETE = R.id.delete

fun <V : GymView, P : Presenter<V>> BaseFragment<V, P>.done(nav: Nav) = (activity as BaseActivity<V, P>).done(nav)

fun AppCompatActivity.setToolbar(title: Int) {
    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    supportActionBar!!.title = ""
    tvTitle.text = getString(title)
}

fun AppCompatActivity.setToolbarIcon(
        icon: Int = R.drawable.ic_arrow_back_black_24dp,
        color: Int = R.color.primary
) {
    supportActionBar!!.setHomeAsUpIndicator(icon)
    supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    toolbar.backgroundResource = color
}

fun Fragment.setToolbar(title: Int) = (activity as AppCompatActivity).setToolbar(title)

fun Fragment.setToolbarIcon(
        icon: Int = R.drawable.ic_arrow_back_black_24dp,
        color: Int = R.color.primary
) = (activity as AppCompatActivity).setToolbarIcon(icon, color)

infix fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)

inline fun <reified T : Activity> Activity.goToActivity(pairs: List<Pair<String, Command>>) {
    val intent = Intent(this, T::class.java)
    pairs.map { intent.putExtra(it.first, it.second) }
    startActivity(intent)
}

inline fun <reified T : Fragment> create(ar: List<Pair<String, Command>> = listOf()): T {
    val exerciseFragment = getFr(T::class.java)
    val args = Bundle()
    ar.map { args.putSerializable(it.first, it.second) }
    exerciseFragment.arguments = args
    return exerciseFragment
}

fun <T> getFr(c: Class<T>) = c.newInstance()

fun Fragment.load(f: Fragment) =
        activity.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_right)
                .replace(R.id.container, f)
                .commit()


fun Fragment.navMenu(f: Fragment) = Action {
    activity.supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_right)
            .replace(R.id.container, f)
            .commit()
}

inline fun <reified T : Fragment> AppCompatActivity.loadFr(ar: List<Pair<String, Command>> = listOf()) {
    supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_right)
            .replace(R.id.container, create<T>(ar), T::class.java.simpleName)
            .commit()
}

inline fun <reified V : GymView, P : Presenter<V>, T : BaseFragment<V, P>> BaseActivity<V, P>.refresh(fragment: T) = fragment.refresh()

inline fun <reified T : Fragment> AppCompatActivity.getFr(): T =
        supportFragmentManager.findFragmentByTag(T::class.java.simpleName) as T

inline fun <reified T : Activity> Activity.load(pairs: List<Pair<String, Command>> = listOf()) {
    goToActivity<T>(pairs)
    finish()
    setSlideRightAnimation()
}

inline fun <reified T : Activity> Fragment.load(pairs: List<Pair<String, Command>> = listOf()) = with(activity) {
    goToActivity<T>(pairs)
    finish()
    setSlideRightAnimation()
}

inline fun <reified T : Activity> Fragment.loadStack(pairs: List<Pair<String, Command>> = listOf()) = with(activity) {
    goToActivity<T>(pairs)
    setSlideRightAnimation()
}

inline fun <reified T : Activity> Activity.navStack(pairs: List<Pair<String, Command>> = listOf()) {
    goToActivity<T>(pairs)
    setSlideRightAnimation()
}

inline fun <reified T : Activity> Activity.nav(pairs: List<Pair<String, Command>> = listOf()) {
    goToActivity<T>(pairs)
    setSlideRightAnimation()
    finish()
}

fun Activity.navBack() = Action {
    finish()
    setSlideExitToRightAnimation()
}

fun Fragment.navBack() = activity.navBack()

inline fun <reified T : Activity> Activity.menuNav() = Action { load<T>(listOf()) }

fun Action(f: () -> Unit): Boolean {
    f()
    return true
}

fun Activity.inject() {
    when (this) {
        is ExerciseActivity -> GymApplication.appComponent.plus(ExerciseModule(this)).inject(this)
        is ExerciseTypeActivity -> GymApplication.appComponent.plus(ExerciseTypeModule(this)).inject(this)
        is MuscleGroupActivity -> GymApplication.appComponent.plus(MuscleGroupModule(this)).inject(this)
        is RoutineActivity -> GymApplication.appComponent.plus(RoutinesModule(this)).inject(this)
        is SessionActivity -> GymApplication.appComponent.plus(SessionModule(this)).inject(this)
        is SplashActivity -> GymApplication.appComponent.plus(SplashModule(this)).inject(this)
        is WeightActivity -> GymApplication.appComponent.plus(WeightModule(this)).inject(this)
        is RepActivity -> GymApplication.appComponent.plus(RepModule(this)).inject(this)
        is NewSessionActivity -> GymApplication.appComponent.plus(NewSessionModule(this)).inject(this)
        is SessionSetActivity -> GymApplication.appComponent.plus(SessionSetModule(this)).inject(this)
    }
}

fun Fragment.inject() {
    when (this) {
        is MuscleGroupFragment -> GymApplication.appComponent.plus(MuscleGroupFragmentModule(this)).inject(this)
        is ExerciseTypeFragment -> GymApplication.appComponent.plus(ExerciseTypeFragmentModule(this)).inject(this)
        is ExerciseFragment -> GymApplication.appComponent.plus(ExerciseFragmentModule(this)).inject(this)
        is WeightFragment -> GymApplication.appComponent.plus(WeightFragmentModule(this)).inject(this)
        is RepFragment -> GymApplication.appComponent.plus(RepFragmentModule(this)).inject(this)
        is SessionFragment -> GymApplication.appComponent.plus(SessionFragmentModule(this)).inject(this)
        is SessionSetFragment -> GymApplication.appComponent.plus(SessionSetFragmentModule(this)).inject(this)
    }
}

fun Activity.gridLayoutManager(cels: Int = 2) = GridLayoutManager(this, cels)
fun Fragment.gridLayoutManager(cels: Int = 2) = GridLayoutManager(context, cels)

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun MenuInflater.make(menuRes: Int, menu: Menu) = Action { inflate(menuRes, menu) }

fun SeekBar.listener(f: (Int) -> Unit) = setOnSeekBarChangeListener(SeekBarListener { f(it) })

fun Activity.getExtra(): Id = intent?.getSerializableExtra(extra)?.let { it as Id } ?: Id("")
//fun Activity.getId(): Option<Id> = intent?.getSerializableExtra("id")?.let { Option(it as Id) } ?: Option.None
fun <E : Command> Activity.getId(): Option<E> = intent?.getSerializableExtra(extra)?.let { Option(it as E) } ?: Option.None

//fun Fragment.getArgId(): Option<Id> = arguments?.getSerializable("id")?.let { Option(it as Id) } ?: Option.None
fun <E : Command> Fragment.getArgId(): Option<E> = arguments?.getSerializable(extra)?.let { Option(it as E) } ?: Option.None

const val extra: String = "EXTRA"