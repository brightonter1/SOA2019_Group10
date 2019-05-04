<template>
    <div class="app" style="text-align: -moz-center">
        <h1>Statement</h1>
        <el-date-picker
                v-model="statementMonth"
                type="monthrange"
                align="right"
                unlink-panels
                range-separator="ถึง"
                start-placeholder="ตั้งแต่"
                end-placeholder="สิ้นสุด"
                :picker-options="pickerOptions"
        style="margin-bottom: 20px">
        </el-date-picker>
        <el-table
                :data="tableData"
                :default-sort = "{prop: 'date', order: 'descending'}"
                style="width: 80%;">
            <el-table-column
                    prop="date"
                    label="Date"
                    sortable>
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="Name"
                    width="300">
            </el-table-column>
            <el-table-column
                    prop="exp"
                    label="Expiration date"
            sortable>
            </el-table-column>
            <el-table-column
                    prop="price"
                    label="price"
                    sortable
                    width="180">
            </el-table-column>
            <el-table-column
                    label="operation"
            align="right">
                <el-button
                        size="mini">Edit</el-button>
                <el-button
                        size="mini"
                        type="danger">Delete</el-button>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "Statement",
        data() {
            return {
                pickerOptions: {
                    shortcuts: [{
                        text: 'เดือนปัจจุบัน',
                        onClick(picker) {
                            picker.$emit('pick', [new Date(), new Date()]);
                        }
                    }, {
                        text: 'ปีนี้',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date(new Date().getFullYear(), 0);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '6 เดือนล่าสุด',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setMonth(start.getMonth() - 6);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },
                statementMonth: '',
                tableData: [{
                    date: '2019-05-03',
                    name: 'Tom',
                    exp: '2019-05-03',
                    price: 500
                }, {
                    date: '2019-05-02',
                    name: 'Tom',
                    exp: '2019-05-03',
                    price: 400.00
                }, {
                    date: '2019-05-04',
                    name: 'Tom',
                    exp: '2019-05-03',
                    price: 700.00
                }, {
                    date: '2019-05-01',
                    name: 'Tom',
                    exp: '2019-05-03',
                    price: 600.00
                }]
            };
        },
        // methods: {
        //     formatter(row, column) {
        //         return row.address;
        //     }
        // }
    }
</script>

<style scoped>
</style>
