


    google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);


        function drawChart() {
         timeframe = document.getElementById("thedropdown").value;

         info = [{time: "weekly", entertainment: 40, food: 8, commute: 4, car: 3, phone: 40},
         {time: "monthly", entertainment: 45, food: 9, commute: 3, car: 5, phone: 50}
         ];

        for(i=0; i<info.length; i++) {
        if(timeframe == info[i].time) {
           entertainment = info[i].entertainment;
           food = info[i].food;
           commute = info[i].commute;
           car = info[i].car;
           phone = info[i].phone;

        }// end if
        } // end for

        var data = google.visualization.arrayToDataTable([
              ['Bill', 'Dollars'],
              ['Entertainment',     entertainment],
              ['Food',     food],
              ['Commute',  commute],
              ['Car',      car],
              ['Phone',    phone]
            ]);
            var options = {
              title: 'Spending Data',
              colors: ['orange','#00cc33', 'pink', 'yellow','lightblue']
            };
            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
          }

        // this function makes the chart responsive; include the name of the proper drawChart function; if more than one chart on page, include additional statements for each drawChart function
        window.onresize = function() {
        drawChart();
        }
