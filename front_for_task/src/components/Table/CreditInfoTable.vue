<template>
  <div class="credit-info-table-elem">
    <table class="table-credit-info">
      <thead>
        <tr>
          <th>
            <h1>Месяц/Год</h1>
          </th>
          <th>
            <h1>Платеж по основному долгу</h1>
          </th>
          <th>
            <h1>Платеж по процентам</h1>
          </th>
          <th>
            <h1>Остаток основного долга</h1>
          </th>
          <th>
            <h1>Общая сумма платежа</h1>
          </th>
        </tr>
      </thead>

      <tbody>
        <tableElement
          v-for="record in tableCreditInformation"
          :key="record.id"
          :credit_data="record"
        />
      </tbody>

    </table>
  </div>
</template>

<script>
import tableElement from "./CreditInfoTableElement";

export default {
  name: "CreditInfoTable",
  components: {
    tableElement,
  },
  props: {
    tableCreditInformation: {
      type: Array,
      default() {
        return {};
      },
    },
  }
};
</script>

<style lang="scss" scoped>
.credit-info-table-elem {
  background: #f7f8f8;
  height: 100%;
}
.table-credit-info {
  width: 100%;
  margin-bottom: 20px;
  border-collapse: separate;
  margin: auto;
  border-spacing: 5px;
  
}
.table-credit-info th {
  background: #627786;
  color: white;
  text-align: center;
}
.table-credit-info tr {
  width: 100%;
  text-align: center;
}

</style>
