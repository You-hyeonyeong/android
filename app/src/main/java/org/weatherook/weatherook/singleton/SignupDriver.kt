package org.weatherook.weatherook.singleton

import io.reactivex.subjects.PublishSubject

object SignupDriver {
    val signupDriver : PublishSubject<Boolean> = PublishSubject.create()
}