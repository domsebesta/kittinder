import Vue from 'vue'
import VueRouter from "vue-router"
import UserLogin from "@/views/UserLogin"
import HomePage from "@/views/HomePage"
import UserProfile from "@/views/UserProfile"
import UserRegistration from "@/views/UserRegistration"

Vue.use(VueRouter)

export default new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/register',
            name: 'register',
            component: UserRegistration
        },
        {
            path: '/login',
            name: 'login',
            component: UserLogin
        },
        {
            path: '/',
            name: 'home',
            component: HomePage
        },
        {
            path: '/profile',
            name: 'profile',
            component: UserProfile
        },
    ]
})