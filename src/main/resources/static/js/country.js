$('document').ready(function(){

    $('table #editButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href,function(country, status){
             $('#editId').val(country.id);
             $('#editDescription').val(country.description);
             $('#editCapital').val(country.capital);
             $('#editCode').val(country.code);
             $('#editContinent').val(country.continent);
             $('#editNationality').val(country.nationality);
        });

        $('#editModal').modal();
    });
});