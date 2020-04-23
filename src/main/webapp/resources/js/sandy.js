$("document").ready(function()
{
	var id;
	$(":button").on("click", function()
			{
				var id = $(this).parent().parent().children(":first").children(":first").attr("id");
				var value = $("#" + id).val();
				console.log(id);
				var getUrl = window.location;
				var baseUrl = getUrl .protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
				
				var data={};
				data[id] = value;
				if(value.length>=2)
				{
					$.ajax({
						  method: "POST",
						  url: baseUrl+"/editAccount",
						  data: data,
						})
						  .done(function( msg ) {
							  var t = $("#msg");
							  t.text(msg); 
						});
				}
			});
	
	
});