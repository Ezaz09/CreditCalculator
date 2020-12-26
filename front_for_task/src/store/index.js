import Vue from 'vue';
import Vuex from 'vuex';
import axiosInstance from '@/api/index';
import { CALCULATE_CREDIT } from '@/api/routes';

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    creditInfo: new Object
  },
  mutations: {
    setCreditInfo(state, creditInfo) {
      state.creditInfo = creditInfo;
    }
  },
  actions: {
    fetchCreditInfo(context, payload) {
      return axiosInstance.get(CALCULATE_CREDIT(payload.sumOfCredit, payload.countOfMonthsOfCredit, payload.percentsPerYear), { headers: { 'Access-Control-Allow-Origin': '*' }})
      .then(({data})=> {
        context.commit('setCreditInfo', data['listOfMonthPayment']);
      })
      .catch(err => console.log(err));
    }
  },
  modules: {
  }
})
