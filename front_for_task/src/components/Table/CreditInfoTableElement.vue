<template>
  <tr>
    <td>
      <h1>{{ credit_data.monthYear }}</h1>
    </td>
    <td>
      <h1>{{ credit_data.paymentForMainDebt }}</h1>
    </td>
    <td>
      <h1>{{ credit_data.paymentForPercents }}</h1>
    </td>
    <td>
      <h1>{{ credit_data.remainsOfMainDebt }}</h1>
    </td>
    <td>
      <h1>{{ credit_data.amountOfTotalPayment }}</h1>
    </td>
  </tr>
</template>

<script>
export default {
  name: "TableElement",
  components: {},
  props: {
    credit_data: {
      type: Object,
      default() {
        return {};
      },
    },
  },
};
</script>
