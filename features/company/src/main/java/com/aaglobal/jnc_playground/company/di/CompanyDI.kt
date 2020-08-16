package com.aaglobal.jnc_playground.company.di

import com.aaglobal.jnc_playground.company.routing.CompanyFragmentDetailsRouterSource
import com.aaglobal.jnc_playground.company.routing.CompanyFragmentRouterSource


/**
 * I need to init this object before I start navigating into Companies flow.
 *
 * In real app you may be use some DI-framework (e.g. Toothpick) and bind implementations of this interfaces to
 * appropriate structures of this DI-framework.
 */
object CompanyDI {

    var companyFragmentRouterSource: CompanyFragmentRouterSource? = null
    var companyFragmentDetailsRouterSource: CompanyFragmentDetailsRouterSource? = null

}