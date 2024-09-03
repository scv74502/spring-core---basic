package com.example.core1.scan

import com.example.core1.AutoAppConfig
import com.example.core1.member.MemberService
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

// 심심해서 코틀린으로 짜 봄
class AutoAppConfigTest {

    @Test
    fun basicScan() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java);

        val memberService = ac.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberService::class.java)

    }
}