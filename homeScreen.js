//Code for connectign with REST endpoint when website is loaded
$(document).ready(function () {
    populateTable();

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
function populateTable() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/defects",
        dataType: 'json',
        success: function(defects) {
            var table = $("#defectTable tbody");
            table.empty();

            $.each(defects, function(index, defect) {
                var row = $("<tr>")
                    .addClass("clickable-row")
                    .attr("data-bs-toggle", "modal")
                    .attr("data-bs-target", "#editDefect")
                    .attr("data-id", defect.defectID);

                row.append($("<th scope=\"row\">").text(defect.defectID));
                row.append($("<td>").addClass("table-column").text(defect.defectName));
                row.append($("<td>").addClass("table-column").text(defect.defectDescription));
                row.append($("<td>").addClass("table-column").text(defect.defectStatus));
                row.append($("<td>").addClass("table-column").text(defect.createdBy));
                row.append($("<td>").addClass("table-column").text(defect.assignedTo));

                table.append(row);
    });
        },
        error: function() {
            console.error("Error getting defect data");
        }
    });
}

//Function to populate the modal when a row is clicked
function populateModal(defectID) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/singleDefect?defectID=" + defectID,
        dataType: 'json',
        success: function(data) {
            console.log(data);

            $("#CurrentDefectID").val(data.defectID);
            $("#CurrentDefectName").val(data.defectName);
            $("#CurrentDefectDescription").val(data.defectDescription);
            $("#CurrentDefectStatus").val(data.defectStatus);
            $("#CurrentDefectCreatedBy").val(data.createdBy);
            $("#CurrentDefectAssignedTo").val(data.assignedTo);
        },
        error: function() {
            console.error("Error getting defect data");
        }
    })
}

//Call on populateModal when entry is clicked
$(document).on("click", ".clickable-row", function() {
    var defectID = $(this).data("id");
    console.log(defectID);
    populateModal(defectID);
})

//Function to populate defect counter
function populateDefectCount(defectCount) {
    var defectCountTag = $("#defectCount");

    defectCountTag.html("Count: " + defectCount);
}

//Reset new defect form
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("newDefectButton").addEventListener('click', function() {
        document.getElementById("newDefectForm").reset();
    });
});

//Function to add new defect to the Defects table
$(document).on("submit", "#newDefectForm", function(event) {
    event.preventDefault();

    var attachmentsInput = document.getElementById('NewDefectAttachments');
    var attachment = attachmentsInput[0];

    var newDefectData = {
        defectName: $("#NewDefectName").val(),
        defectDescription: $("#NewDefectDescription").val(),
        defectStatus: $("#NewDefectStatus").val(),
        defectAttachments: attachment ? attachment : null, 
        createdBy: $("#NewDefectCreatedBy").val(),
        assignedTo: $("#NewDefectAssignedTo").val()
    };

    console.log(newDefectData);

    $.ajax({
        method: "POST",
        url: "http://localhost:8080/api/addDefect",
        data: JSON.stringify(newDefectData),
        contentType: 'application/json',
        success: function(response) {
            console.log(response);
            populateTable();
            populateDefectCount();
        },
        error: function() {
            console.error("Error getting defect data");
        }
    });
});