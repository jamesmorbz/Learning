(: let $docs := collection("file:/E:/Coding/University/Year4/SemiStructuredData/files/?select=*xml") :)
let $docs := collection("./files/?select=*xml")
(: for some reason I wasn't able to test with the ./files syntax locally, had to use the fully quantified path (file:/) - hopefully this works remotely :)

let $rows := 
    for $s in $docs//s
    for $w in $s/w
    let $next := $w/following-sibling::w[1]
    where lower-case(normalize-space($w)) = 'has'
    return
        <tr>
            <td>{normalize-space(data($w))}</td>
            <td>{normalize-space(data($next))}</td>
            (: stripping both outputs as 'has ' and '$next ' exists:)
        </tr>

return
    <table>
        <tr><th>Target</th><th>Successor</th></tr>
        {$rows}
    </table>