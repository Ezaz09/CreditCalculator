<template>
  <div class="home">
    <p>Размер кредита</p>
    <p>Выбранная сумма: <span id="sumOfCredit"></span></p>
    <input
      type="range"
      min="100000"
      max="5000000"
      value="100000"
      class="slider"
      id="sumOfCreditRange"
    />

    <p>Срок кредита в месяцах</p>
    <p>Количество месяцев: <span id="countOfMonthsOfCredit"></span></p>
    <input
      type="range"
      min="12"
      max="60"
      value="12"
      class="slider"
      id="countOfMonthsOfCreditRange"
    />

    <p>Годовая процентная ставка в %</p>
    <p>Количество процентов: <span id="countOfPercentsOfCredit"></span></p>
    <input
      type="range"
      min="12.9"
      max="23.9"
      value="12.9"
      step="0.1"
      class="slider"
      id="countOfPercentsOfCreditRange"
    />

    <p>
      <input
        type="button"
        v-on:click="fetchInformationAboutCredit"
        value="Рассчитать кредит"
      />
    </p>

    <creditInfoTable :tableCreditInformation="creditInfo" />
  </div>
</template>

<script>
import creditInfoTable from "./Table/CreditInfoTable";

export default {
  name: "home",
  components: {
    creditInfoTable,
  },
  computed: {
    creditInfo() {
      return this.$store.state.creditInfo;
    },
  },
  methods: {
    fetchInformationAboutCredit() {
      var sumOfCredit = document.getElementById("sumOfCreditRange").value;
      var countOfMonthsOfCredit = document.getElementById(
        "countOfMonthsOfCreditRange"
      ).value;
      var percentsPerYear = document.getElementById(
        "countOfPercentsOfCreditRange"
      ).value;

      this.$store.dispatch("fetchCreditInfo", {
        sumOfCredit: sumOfCredit,
        countOfMonthsOfCredit: countOfMonthsOfCredit,
        percentsPerYear: percentsPerYear,
      });
    },
  },
  mounted() {
    var sliderForSumOfCredit = document.getElementById("sumOfCreditRange");
    var outputForSumOfCredit = document.getElementById("sumOfCredit");
    outputForSumOfCredit.innerHTML = sliderForSumOfCredit.value;

    sliderForSumOfCredit.oninput = function() {
      outputForSumOfCredit.innerHTML = this.value;
    };

    var sliderForCountOfMonthsOfCredit = document.getElementById(
      "countOfMonthsOfCreditRange"
    );
    var outputForCountOfMonthsOfCreditRange = document.getElementById(
      "countOfMonthsOfCredit"
    );
    outputForCountOfMonthsOfCreditRange.innerHTML =
      sliderForCountOfMonthsOfCredit.value;

    sliderForCountOfMonthsOfCredit.oninput = function() {
      outputForCountOfMonthsOfCreditRange.innerHTML = this.value;
    };

    var sliderForCountOfPercentsOfCredit = document.getElementById(
      "countOfPercentsOfCreditRange"
    );
    var outputForCountOfPercentsOfCreditRange = document.getElementById(
      "countOfPercentsOfCredit"
    );
    outputForCountOfPercentsOfCreditRange.innerHTML =
      sliderForCountOfPercentsOfCredit.value;

    sliderForCountOfPercentsOfCredit.oninput = function() {
      outputForCountOfPercentsOfCreditRange.innerHTML = this.value;
    };
  },
};
</script>

<style scoped></style>
