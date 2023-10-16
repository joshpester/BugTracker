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
document.addEventListener('DOMContentLoaded', function() {
    viewSelector.addEventListener('change', function() {
        const selectedView = viewSelector.value;
        loadPage(selectedView);
    });
});

//Load default view
loadPage(viewSelector.value);