
function graph(){
	$(document).ready(function(){
	
		$.getJSON("https://my.engr.illinois.edu/labtrack/util_data_json.asp?callback=?",
			function(json_data) {
				var items = [];
  				$.each(json_data.data, function(key, val) {
    				items.push('<div id="' + val.strlabname.replace(/ /g,"_") + '" class="lab">' + 
    				'<div class="name">' + val.strlabname + '</div>' +
    				'<div class="graph" style="width: ' + Math.round(((val.inusecount / val.machinecount) * 100)) / 2.2 + '%; margin-right: ' + 
    				Math.round((100 - Math.round(((val.inusecount / val.machinecount) * 100)))) / 2.2 + '%;">&nbsp;</div>' + 
    				'<div class="count">' + val.inusecount + ' / ' + val.machinecount + '</div><div class="clear">&nbsp;</div>' + 
    				'</div>');
  				});

  			$('#workstations #data').html(items.join(''));
  			
  			});
		});
	}
