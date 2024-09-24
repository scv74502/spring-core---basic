package com.example.core.scan

import com.example.core.AutoAppConfig
import com.example.core.member.MemberRepository
import com.example.core.member.MemberService
import com.example.core.order.OrderServiceImpl
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

// 심심해서 코틀린으로 짜 봄
class AutoAppConfigTest {

    @Test
    fun basicScan() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)

        val memberService = ac.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberService::class.java)

        val bean = ac.getBean(OrderServiceImpl::class.java)
//        val memberRepository:MemberRepository = bean.memberRepository
        println("memberRepository : ${bean.memberRepository}")
    }
}