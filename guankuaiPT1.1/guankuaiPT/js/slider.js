 $(function(){
               $(".menubox").find(".menuclick").click(function(){
              // $(this).parent().siblings().find(".submenu").slideUp("fast");
              // $(this).next().slideToggle("fast");
              $(this).next().slideToggle("fast").end().parent().siblings().find(".submenu").slideUp("fast").end().find("i").text("+");
              var t = $(this).find("i").text();
              $(this).find("i").text((t=="+"?"-":"+"));
    		});
	    });