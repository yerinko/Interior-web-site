( function ( $ ) {

    var controller = new slidebars();

    	//효과 
    $( controller.events ).on( 'init', function () {
        console.log( 'Init event' );
    } );

    $( controller.events ).on( 'exit', function () {
        console.log( 'Exit event' );
    } );

    $( controller.events ).on( 'css', function () {
        console.log( 'CSS event' );
    } );

    $( controller.events ).on( 'opening', function ( event, id ) {
        console.log( 'Opening event of slidebar with id ' + id );
    } );

    $( controller.events ).on( 'opened', function ( event, id ) {
        console.log( 'Opened event of slidebar with id ' + id );
    } );

    $( controller.events ).on( 'closing', function ( event, id ) {
        console.log( 'Closing event of slidebar with id ' + id );
    } );

    $( controller.events ).on( 'closed', function ( event, id ) {
        console.log( 'Closed event of slidebar with id ' + id );
    } );


    controller.init();

   
    $( '.js-open-left-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.open( 'slidebar-1' );
    } );

    $( '.js-close-left-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.close( 'slidebar-1' );
    } );

    $( '.js-toggle-left-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.toggle( 'slidebar-1' );
    } );


    $( '.js-open-right-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.open( 'slidebar-2' );
    } );

    $( '.js-close-right-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.close( 'slidebar-2' );
    } );

    $( '.js-toggle-right-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.toggle( 'slidebar-2' );
    } );

    $( '.js-open-top-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.open( 'slidebar-3' );
    } );

    $( '.js-close-top-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.close( 'slidebar-3' );
    } );

    $( '.js-toggle-top-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.toggle( 'slidebar-3' );
    } );


    $( '.js-open-bottom-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.open( 'slidebar-4' );
    } );

    $( '.js-close-bottom-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.close( 'slidebar-4' );
    } );

    $( '.js-toggle-bottom-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.toggle( 'slidebar-4' );
    } );


    $( controller.events ).on( 'opened', function () {
        $( '[canvas="container"]' ).addClass( 'js-close-any-slidebar' );
    } );

    $( controller.events ).on( 'closed', function () {
        $( '[canvas="container"]' ).removeClass( 'js-close-any-slidebar' );
    } );

    $( 'body' ).on( 'click', '.js-close-any-slidebar', function ( event ) {
        event.stopPropagation();
        controller.close();
    } );


    $( '.js-initialize-slidebars' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.init();
    } );

    $( '.js-exit-slidebars' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.exit();
    } );

    $( '.js-reset-slidebars-css' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.css();
    } );


    $( '.js-is-active' ).on( 'click', function ( event ) {
        event.stopPropagation();
        console.log( controller.isActive() );
    } );

    $( '.js-is-active-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        var id = prompt( 'Enter a Slidebar id' );
        console.log( controller.isActiveSlidebar( id ) );
    } );

    $( '.js-get-active-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        console.log( controller.getActiveSlidebar() );
    } );

    $( '.js-get-all-slidebars' ).on( 'click', function ( event ) {
        event.stopPropagation();
        console.log( controller.getSlidebars() );

    } );

    $( '.js-get-slidebar' ).on( 'click', function ( event ) {
        event.stopPropagation();
        var id = prompt( 'Enter a Slidebar id' );
        console.log( controller.getSlidebar( id ) );
    } );


    $( '.js-init-callback' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.init( function () {
            console.log( 'Init callback' );
        } );
    } );

    $( '.js-exit-callback' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.exit( function () {
            console.log( 'Exit callback' );
        } );
    } );

    $( '.js-css-callback' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.css( function () {
            console.log( 'CSS callback' );
        } );
    } );

    $( '.js-open-callback' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.open( 'slidebar-1', function () {
            console.log( 'Open callback' );
        } );
    } );

    $( '.js-close-callback' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.close( function () {
            console.log( 'Close callback' );
        } );
    } );

    $( '.js-toggle-callback' ).on( 'click', function ( event ) {
        event.stopPropagation();
        controller.toggle( 'slidebar-1', function () {
            console.log( 'Toggle callback' );
        } );
    } );
} ) ( jQuery );