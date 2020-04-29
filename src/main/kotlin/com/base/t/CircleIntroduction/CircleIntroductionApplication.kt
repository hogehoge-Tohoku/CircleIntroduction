package com.base.t.CircleIntroduction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CircleIntroductionApplication {

	companion object {
		@JvmStatic fun main(args: Array<String>) {
			runApplication<CircleIntroductionApplication>(*args)
		}
	}
}
