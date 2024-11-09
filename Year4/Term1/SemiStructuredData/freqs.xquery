(: let $docs := collection("file:/E:/Coding/University/Year4/SemiStructuredData/files/?select=*xml") :)
let $docs := collection("./files/")

let $pairs := for $s in $docs//s
              for $w in $s/w
              let $next := $w/following-sibling::w[1]
              where lower-case(normalize-space($w)) = 'has'
              return concat(data($w), ' ', data($next))

(: creating results var so I can append to a list which allows me to put the headers row on the table otherwise I'd be outputting the headers each iteration:)              
let $results :=
    for $uniquePair in distinct-values($pairs)
    let $target := substring-before($uniquePair, ' ')
    let $successor := substring-after($uniquePair, ' ')
    let $pairFreq := count($pairs[. = $uniquePair])
    order by $pairFreq descending
    return
        <tr>
            <td>{normalize-space($target)}</td>
            <td>{normalize-space($successor)}</td>
            <td>{$pairFreq}</td>
        </tr>

return
    <table>
        <tr><th>Target</th><th>Successor</th><th>Frequency</th></tr>
        {$results}
    </table>