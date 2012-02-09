Ext.onReady(function(){

	//JSON数据
    var data = {
        name: 'Jack Slocum',
        company: 'Ext JS, LLC',
        address: '4 Red Bulls Drive',
        city: 'Cleveland',
        state: 'Ohio',
        zip: '44102',
        kids: [{
            name: 'Sara Grace',
            age:3
        },{
            name: 'Zachary',
            age:2
        },{
            name: 'John James',
            age:0
        }]
    };

    var p = new Ext.Panel({
        title: 'Basic Template',
        width: 300,
        html: '<p><i>Apply the template to see results here</i></p>',
        tbar: [{
            text: 'Apply Template',
            handler: function(){

                var tpl = new Ext.Template(
                    '<p>Name: {name}</p>',
                    '<p>Company: {company}</p>',
                    '<p>Location: {city}, {state}</p>'
                );

                tpl.overwrite(p.body, data);	//将JSON格式的数据,运用到模板的内容中(占位符).并将模板的内容重写到呈现的div里.
                p.body.highlight('#c3daf9', {block:true});
            }
        }],

        renderTo: document.body
    });


    var p2 = new Ext.Panel({
        title: 'XTemplate',
        width: 300,
        html: '<p><i>Apply the template to see results here</i></p>',
        tbar: [{
            text: 'Apply Template',
            handler: function(){

                var tpl = new Ext.XTemplate(
                    '<p>Name: {name}</p>',
                    '<p>Company: {company}</p>',
                    '<p>Location: {city}, {state}</p>',
                    '<p>Kids: ',
                    '<tpl for="kids" if="name==\'Jack Slocum\'">',
                        '<tpl if="age &gt; 1"><p>{#}. {parent.name}\'s kid - {name}</p></tpl>',
                    '</tpl></p>'
                );
                tpl.overwrite(p2.body, data);
                p2.body.highlight('#c3daf9', {block:true});
            }
        }],

        renderTo: document.body
    });
});