The message is: ${msg}

<#list devices as device>
${device.title}: ${device.price}
</#list>  
-------------------------------------
Conditions:


<#assign x = 1>  x = ${msg}
${x}
<#if (${x}) == "TV"> Here


<#list devices as device>



</#list>  