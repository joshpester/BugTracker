//Code for when website is loaded
$(document).ready(function () {
    //Load default view
    loadPage(viewSelector.value);
});

// Start Code for switching between different dashboard views

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
            if(view == "dashboardTotal.html") {
                populateTotalDefectCount();
                populateOpenDefectCount();
                populateInProgressDefectCount();
                populateClosedDefectCount();
            }
            if(view == "dashboardByUser.html") {
                populateDefectCountsByUserTable();
            }
        })
        .catch(error => {
            console.error('Error loading page:', error);
        });
}

//Code for switching between views on the dashboard
viewSelector.addEventListener('change', function() {
    const selectedView = viewSelector.value;
    loadPage(selectedView);
});

// End Code for switching between different dashboard views

//Function to populate total defect counter
function populateTotalDefectCount() {
    $(document).ready(function () {
        var totalDefectCountTag = $("#totalDefectCount");
    
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/defectCount",
            success: function(totalDefectCount) {
                totalDefectCountTag.html(totalDefectCount);
            },
            error: function() {
                console.error("Error getting defect data");
            }
        });
    });
}

//Function to populate open defect counter
function populateOpenDefectCount() {
    $(document).ready(function () {
        var openDefectCountTag = $("#openDefectCount");
    
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/openDefectCount",
            success: function(openDefectCount) {
                openDefectCountTag.html(openDefectCount);
            },
            error: function() {
                console.error("Error getting defect data");
            }
        });
    });
}

//Function to populate in progress defect counter
function populateInProgressDefectCount() {
    $(document).ready(function () {
        var inProgressDefectCountTag = $("#inProgressDefectCount");
    
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/inProgressDefectCount",
            success: function(inProgressDefectCount) {
                inProgressDefectCountTag.html(inProgressDefectCount);
            },
            error: function() {
                console.error("Error getting defect data");
            }
        });
    });
}

//Function to populate closed defect counter
function populateClosedDefectCount() {
    $(document).ready(function () {
        var closedDefectCountTag = $("#closedDefectCount");
    
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/closedDefectCount",
            success: function(closedDefectCount) {
                closedDefectCountTag.html(closedDefectCount);
            },
            error: function() {
                console.error("Error getting defect data");
            }
        });
    });
}

//Function to populate the Defect Status counts by User on the dashboardByUser view
function populateDefectCountsByUserTable() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/defectCountsByUser",
        dataType: 'json',
        success: function(defectCountsByUser) {
            var table = $("#defectCountsByUserTable tbody");
            table.empty();

            $.each(defectCountsByUser, function(index, user) {
                var row = $("<tr>")

                row.append($("<th scope=\"row\">").text(user.userName));
                row.append($("<td>").addClass("table-column").text(user.openDefectsCount));
                row.append($("<td>").addClass("table-column").text(user.inProgressDefectsCount));
                row.append($("<td>").addClass("table-column").text(user.closedDefectsCount));
                table.append(row);
            });
        },
        error: function() {
            console.error("Error getting defect data");
        }
    });
}