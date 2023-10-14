//Code for clicking on table entries
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/defects",
        dataType: 'json',
        success: function(data) {
            populateTable(data);
        },
        error: function() {
            console.error("Error getting defect data");
        }
    })

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/defectCount",
        dataType: 'json',
        success: function(data) {
            populateDefectCount(data);
        },
        error: function() {
            console.error("Error getting defect data");
        }
    })
});

//Function to populate table dynamically with defect data
function populateTable(defects) {
    var table = $("#defectTable tbody");

    $.each(defects, function(index, defect) {
        var row = $("<tr>")
            .addClass("clickable-row")
            .attr("data-bs-toggle", "modal")
            .attr("data-bs-target", "#editDefect")
            .attr("data-id", 1);

        row.append($("<th scope=\"row\">").text(defect.defectID));
        row.append($("<td>").text(defect.defectName));
        row.append($("<td>").text(defect.defectDescription));
        row.append($("<td>").text(defect.defectStatus));
        row.append($("<td>").text(defect.createdBy));
        row.append($("<td>").text(defect.assignedTo));

        table.append(row);
    });
}

//Function to populate defect counter
function populateDefectCount(defectCount) {
    var defectCountTag = $("#defectCount");

    defectCountTag.html("Count: " + defectCount);
}

//Code for switching between different dashboard views

//Create variables for references to dropdown and view contianers
const viewSelector = document.getElementById('viewSelector');
const dashboardViewContainer = document.getElementById('dashboardViewContainer');

//Function to load contain based on the selected dashboard view
function loadPage(view) {
    console.log(view);
    fetch(view)
        .then(response => response.text())
        .then(html => {
            dashboardViewContainer.innerHTML = html;
        })
        .catch(error => {
            console.error('Error loading page:', error);
        });
}

//Add event listener to the dropdown
viewSelector.addEventListener('change', function() {
    const selectedView = viewSelector.value;
    loadPage(selectedView);
});

//Load default view
loadPage(viewSelector.value);