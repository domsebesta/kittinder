import Vue from "vue"
import Vuex from "vuex"
import {getAPI} from "@/axios-api"
import createPersistedState from "vuex-persistedstate"

Vue.use(Vuex)
export default new Vuex.Store({
    state: {
        accessToken: null,
        APIData: ''
    },
    mutations: {
        updateStorage (state, { access }) {
            this.state.accessToken = access
        },
        destroyToken (state) {
            state.accessToken = null
        }
    },
    getters: {
        loggedIn(state) {
            return state.accessToken != null
        }
    },
    plugins: [createPersistedState()],
    actions: {
        userLogin (context, usercredentials) {
            return new Promise ((resolve, reject) => {
                getAPI.post('/api/token', {}, {
                    auth: {
                        username: usercredentials.username,
                        password: usercredentials.password
                    }
                } )
                    .then(response => {
                        context.commit('updateStorage', {access: response.data})
                        console.log(response.data)
                        resolve()
                    })
                    .catch(() => {
                        reject()
                    })
            })
        },
        userLogout (context) {
            return new Promise((resolve) => {
                if(context.getters.loggedIn){
                    context.commit('destroyToken')
                    resolve()
                } else {
                    resolve()
                }
            })
        }
    }
})