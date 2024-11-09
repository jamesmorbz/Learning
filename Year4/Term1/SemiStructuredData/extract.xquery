(: let $docs := collection("file:/E:/Coding/University/Year4/SemiStructuredData/files/?select=*xml") :)
let $docs := collection("./files/")
(: for some reason adding the ?select=*xml param to the collection function didn't work for me locally :)

let $rows := 
    for $s in $docs//s
    for $w in $s/w
    let $next := $w/following-sibling::w[1]
    where lower-case(normalize-space($w)) = 'has'
    return
        <tr>
            <td>{normalize-space(data($w))}</td>
            <td>{normalize-space(data($next))}</td>
        </tr>

(: stripping both outputs as 'has ' and '$next ' exists:)

return
    <table>
        <tr><th>Target</th><th>Successor</th></tr>
        {$rows}
    </table>