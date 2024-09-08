package com.example.core.scan

import com.example.core.AutoAppConfig
import com.example.core.member.MemberService
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