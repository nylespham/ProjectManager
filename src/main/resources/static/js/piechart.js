const ctx = document.getElementById('myPieChart');
const chartData= JSON.parse(decodeHtml(chartData));
const labelData = []
const numericData = []
for (var x =0; x < chartData.length - 1; x++ ){
    labelData[x] = chartData.stage
    numericData[x] = chartData.value
}
new Chart(ctx, {
    type: "pie",
    data: {
        labels: labelData,
        datasets: [{
            label: 'Project Count',
            data: numericData,
            borderWidth: 1
        }]
    },
    options: {
        title: {
            display: true,
            text: "Project Statuses"
        }
    }
});

function decodeHtml(html) {
    const txt = document.createElement("textarea");
    txt.innerHTML = html;
   return txt.value
}